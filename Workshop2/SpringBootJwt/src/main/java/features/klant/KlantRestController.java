package features.klant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KlantRestController {
	
	@Autowired
	private KlantDao klantDao;
	
	@RequestMapping(method=RequestMethod.GET, value="/klant")
	public @ResponseBody List<Klant> getAlleKlanten() {
	    List<Klant> klanten = klantDao.findAll();
            return klanten;
	}

}
