import com.hairpet.controler.db.ServiceClient;
import com.hairpet.controler.db.ServiceHairdresser;
import com.hairpet.controler.db.ServiceInventory;
import com.hairpet.controler.db.ServicePet;
import com.hairpet.controler.db.ServiceUser;
import com.hairpet.controler.db.ServiceVisit;
import com.hairpet.view.form.LoginForm;

public class HairPet {

	private static final boolean createTablesAndCheckData = false;

	public static void main(String[] args) {

		if (createTablesAndCheckData)
			creaBaseDatos();
		new LoginForm();
	}

	public static void creaBaseDatos() {
		ServiceHairdresser haidresserService = new ServiceHairdresser();
		ServiceUser userService = new ServiceUser();
		ServiceClient clientService = new ServiceClient();
		ServicePet petService = new ServicePet();
		ServiceVisit visitService = new ServiceVisit();
		ServiceInventory inventoryService = new ServiceInventory();

		haidresserService.datosPrueba();
		userService.datosPrueba();
		clientService.datosPrueba();
		petService.datosPrueba();
		visitService.datosPrueba();
		inventoryService.datosPrueba();
	}

}
