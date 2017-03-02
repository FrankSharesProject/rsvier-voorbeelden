/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package features.artikel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ArtikelController {
    
    @Autowired
    ArtikelDao artikelDao;
    
    @RequestMapping(method=RequestMethod.GET, value="/")
    public String getAlleArtikelen(Model model){
        model.addAttribute("artikelen", artikelDao.findAll());
        return "index";
    }
    
}
