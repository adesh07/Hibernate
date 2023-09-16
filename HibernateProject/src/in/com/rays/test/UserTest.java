package in.com.rays.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.com.rays.model.UserModel;
import in.com.rays.userDTO.UserDTO;

public class UserTest {

	public static void main(String[] args) throws ParseException {

		// testAdd();
		// testUpdate();
		// testDelete();
		// testAuthenticate();
		// testFindByPk();
		testSearch();

	}

	private static void testSearch() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date d = sdf.parse("16-07-2023");
		UserModel model = new UserModel();

		UserDTO dto = new UserDTO();

		// dto.setFirstName("King");
		dto.setDob(d);

		List list = model.search(dto, 0, 0);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			dto = (UserDTO) it.next();
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLoginId());
			System.out.print("\t" + dto.getPassword());
			System.out.print("\t" + dto.getDob());
			System.out.println("\t" + dto.getCity());
		}

	}

	private static void testAdd() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		UserDTO dto = new UserDTO();

		dto.setFirstName("Python");
		dto.setLastName("Language");
		dto.setLoginId("pl@gmail.com");
		dto.setPassword("Pass@123");
		dto.setDob(sdf.parse("16-07-2023"));
		dto.setCity("computer");

		UserModel model = new UserModel();
		model.add(dto);

	}

	private static void testUpdate() {

		UserDTO dto = new UserDTO();

		dto.setId(1);
		dto.setFirstName("King");
		dto.setLastName("Kong");
		dto.setLoginId("kingk10@gmail.com");
		dto.setPassword("Pass@123");
		dto.setDob(new Date());
		dto.setCity("venus");

		UserModel model = new UserModel();
		model.update(dto);
	}

	private static void testDelete() {

		UserDTO dto = new UserDTO();

		dto.setId(4);

		UserModel model = new UserModel();

		model.delete(dto);

	}

	private static void testAuthenticate() {

		UserDTO dto = null;

		UserModel model = new UserModel();

		dto = model.authenticate("kingk11@gmail.com", "Pass@123");

		if (dto != null) {
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLoginId());
			System.out.println(dto.getPassword());
			System.out.println(dto.getDob());
			System.out.println(dto.getCity());
		} else {
			System.err.println("User not found...!!!");
		}
	}

	private static void testFindByPk() {

		UserDTO dto = null;

		UserModel model = new UserModel();

		dto = model.findByPk(2);

		if (dto != null) {
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLoginId());
			System.out.println(dto.getPassword());
			System.out.println(dto.getDob());
			System.out.println(dto.getCity());
		} else {
			System.err.println("User not found...!!!");
		}

	}

}
