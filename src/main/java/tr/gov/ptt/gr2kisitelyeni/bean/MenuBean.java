/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.gr2kisitelyeni.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuItem;
import org.primefaces.model.menu.MenuModel;
import org.primefaces.model.menu.Submenu;

@ManagedBean
@SessionScoped
public class MenuBean {
    
    private MenuModel menuModel;

    public MenuBean() {
        
        menuModel = new DefaultMenuModel();
        initMenu();
    }
    
    public void initMenu()
    {
        DefaultSubMenu kisiSub = new DefaultSubMenu("Kişi İşlemleri");
                
        DefaultSubMenu girisCikisSub = new DefaultSubMenu("Giriş-Çıkış İşlemleri");
        
        DefaultMenuItem menuItem =new DefaultMenuItem();
        menuItem.setValue("Kişi Ekle");
        menuItem.setUrl("kisiEkle.xhtml?faces-redirect=true");
        kisiSub.addElement(menuItem);
        
      menuItem =new DefaultMenuItem();
        menuItem.setValue("Kişi Listele");
        menuItem.setCommand("#{kisiBean.listele()}");
        kisiSub.addElement(menuItem);
        
           menuItem =new DefaultMenuItem();
        menuItem.setValue("Kişi Ara");
        menuItem.setUrl("kisiAra.xhtml?faces-redirect=true");
        kisiSub.addElement(menuItem);
        
          menuItem =new DefaultMenuItem();
        menuItem.setValue("Giriş  İşlemleri");
        menuItem.setUrl("giris.xhtml?faces-redirect=true");
        girisCikisSub.addElement(menuItem);
        
        menuItem =new DefaultMenuItem();
        menuItem.setValue("Çıkış İşlemleri");
        menuItem.setCommand("#{girisBean.guvenliCikis()}");
        girisCikisSub.addElement(menuItem);
 
        menuModel.addElement(kisiSub);
        menuModel.addElement(girisCikisSub);
 
                
    }

    public MenuModel getMenuModel() {
        return menuModel;
    }
    
    
    
    
}
