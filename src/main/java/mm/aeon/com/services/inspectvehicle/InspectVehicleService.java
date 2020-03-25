package mm.aeon.com.services.inspectvehicle;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;

import mm.aeon.com.dao.inspectvehicle.InspectVehicleDao;
import mm.aeon.com.dao.inspectvehicleattachment.InspectVehicleAttachmentDao;
import mm.aeon.com.dao.inspectvehicledriver.InspectVehicleDriverDao;
import mm.aeon.com.dto.inspectvehicle.InspectVehicleAttachmentDto;
import mm.aeon.com.dto.inspectvehicle.InspectVehicleDriverDto;
import mm.aeon.com.dto.inspectvehicle.InspectVehicleDto;
import mm.aeon.com.dto.inspectvehicle.VehicleInfoDto;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class InspectVehicleService {

	@Autowired
	private InspectVehicleDao inspectVehicleDao;

	@Autowired
	private InspectVehicleDriverDao inspectVehicleDriverDao;

	@Autowired
	private InspectVehicleAttachmentDao inspectVehicleAttachmentDao;

	@Value("${properties.imageBaseFilePath}")
	private String imageBaseFilePath;

	@Value("${properties.inspectVehicleImageFolder}")
	private String inspectVehicleImageFolder;

	@Value("${properties.serverAddress}")
	private String serverAddress;

	@Value("${properties.serverPort}")
	private Integer serverPort;

	@Value("${properties.serverUsername}")
	private String serverUsername;

	@Value("${properties.serverPassword}")
	private String serverPassword;

	public void registerNewApplicationWithMultipart(InspectVehicleDto inspectVehicleDto, List<MultipartFile> multipartFileList) throws Exception {

		Integer inspectVehicleId = inspectVehicleDao.insertInspectVehicle(inspectVehicleDto);
		inspectVehicleDto.setInspectVehicleId(inspectVehicleId);

		for (InspectVehicleDriverDto inspectVehicleDriverDto : inspectVehicleDto.getInspectVehicleDriverDtoList()) {
			inspectVehicleDriverDto.setInspectVehicleId(inspectVehicleId);
			inspectVehicleDriverDto.setCreatedUser(inspectVehicleDto.getCreatedUser());
			inspectVehicleDriverDao.insertInspectVehicleDriver(inspectVehicleDriverDto);
		}

		insertInspectVehicleAttachmentUploadWithMultipart(inspectVehicleDto, multipartFileList);

		inspectVehicleDao.updateZoneColumnStatus(inspectVehicleDto.getParkingColumnId(), inspectVehicleDto.getParkingStatus(), inspectVehicleDto.getCreatedUser());

	}

	public void insertInspectVehicleAttachmentUploadWithMultipart(InspectVehicleDto inspectVehicleDto, List<MultipartFile> multipartFileList)
			throws JSchException, SftpException, IOException {

		Session session = null;
		ChannelSftp channelSftp = null;

		JSch jsch = new JSch();
		session = jsch.getSession(serverUsername, serverAddress, serverPort);
		session.setPassword(serverPassword);
		Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);
		session.connect();
		channelSftp = (ChannelSftp) session.openChannel("sftp");
		channelSftp.connect();
		channelSftp.cd("/");

		String[] destinationPath = { imageBaseFilePath, inspectVehicleImageFolder, inspectVehicleDto.getInspectVehicleId().toString() };

		for (String directory : destinationPath) {
			String currentDir = channelSftp.pwd();
			SftpATTRS sftpATTRS = null;
			try {
				if (currentDir.equals("/")) {

					sftpATTRS = channelSftp.stat(directory);

				} else {
					sftpATTRS = channelSftp.stat(currentDir + "/" + directory);
				}
			} catch (SftpException e) {
				continue;
			} finally {
				if (sftpATTRS != null) { // if directory existed.
					channelSftp.chmod(Integer.parseInt("777", 8), directory);
					channelSftp.cd(directory);
				} else { // if directory does not exist.
					channelSftp.mkdir(directory);
					channelSftp.chmod(Integer.parseInt("777", 8), directory);
					channelSftp.cd(directory);
				}
			}

		}

		for (InspectVehicleAttachmentDto inspectVehicleAttachmentDto : inspectVehicleDto.getInspectVehicleAttachmentDtoList()) {
			String filePath = inspectVehicleDto.getInspectVehicleId() + "/" + inspectVehicleAttachmentDto.getFileName();

			inspectVehicleAttachmentDto.setFilePath(filePath);
			inspectVehicleAttachmentDto.setCreatedUser(inspectVehicleDto.getCreatedUser());
			inspectVehicleAttachmentDto.setInspectVehicleId(inspectVehicleDto.getInspectVehicleId());
			inspectVehicleAttachmentDao.insertInspectVehicleAttachment(inspectVehicleAttachmentDto);
		}

		for (MultipartFile multipartFile : multipartFileList) {
			channelSftp.put(multipartFile.getInputStream(), multipartFile.getOriginalFilename(), ChannelSftp.APPEND);
			channelSftp.chmod(Integer.parseInt("777", 8), multipartFile.getOriginalFilename());

		}
		channelSftp.disconnect();
		session.disconnect();

	}

	public VehicleInfoDto getVehicleInfo(String chassisNo) {
		return inspectVehicleDao.getVehicleInfo(chassisNo);
	}

	public Integer getParkingZoneColumnStatus(Integer parkingZoneColumnId) {
		return inspectVehicleDao.getParkingZoneColumnStatus(parkingZoneColumnId);
	}

}
