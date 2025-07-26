package OLS.Pages.ClientRolePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChooseTypeOfLicensingPage
{
    WebDriver driver;

    public ChooseTypeOfLicensingPage(WebDriver driver)
    {
        this.driver=driver;
    }

    /**
     * ліцензії для замовлення (ФОП)
     */
    By FopArtZvitProFopIndividualBasic=By.cssSelector("div.productBlock.ng-scope:nth-child(10)>div:nth-child(2)>div.product__items.ng-scope:nth-child(1) a.btn.btn-success.btn-teal-dk.create-order-btn.ng-scope");
    By FopArtZvitLiteFopWithoutEmployees=By.cssSelector("div.productBlock.ng-scope:nth-child(10)>div:nth-child(2)>div.product__items.ng-scope:nth-child(2) a.btn.btn-success.btn-teal-dk.create-order-btn.ng-scope");
    By FopRightToSwitchToIndividualBasicLicense=By.cssSelector("div.productBlock.ng-scope:nth-child(10)>div:nth-child(2)>div.product__items.ng-scope:nth-child(3) a.btn.btn-success.btn-teal-dk.create-order-btn.ng-scope");
    By FopArtZvitProModuleRro=By.cssSelector("div.productBlock.ng-scope:nth-child(11)>div:nth-child(2)>div.product__items.ng-scope:nth-child(1) a.btn.btn-success.btn-teal-dk.create-order-btn.ng-scope");
    By FopArtZvitProTerminal=By.cssSelector("div.productBlock.ng-scope:nth-child(12)>div:nth-child(2)>div.product__items.ng-scope:nth-child(1) a.btn.btn-success.btn-teal-dk.create-order-btn.ng-scope");

    /**
     * ліцензії для замовлення (ФОП/ФО/ЮО)
     */
    By ArtZvitProPrimaryDocTransaction1=By.cssSelector("div.productBlock.ng-scope:nth-child(14)>div:nth-child(2)>div.product__items.ng-scope:nth-child(2) a.btn.btn-success.btn-teal-dk.create-order-btn.ng-scope");
    By ArtZvitProPrimaryDocModule=By.cssSelector("div.productBlock.ng-scope:nth-child(14)>div:nth-child(2)>div.product__items.ng-scope:nth-child(1) a.btn.btn-success.btn-teal-dk.create-order-btn.ng-scope");
    By ArtOfficeModule1C=By.cssSelector("div.wrapper-md.row.m-t-xs.animated.fadeIn>div.productBlock.ng-scope.ng-hide:nth-child(14)+div a.btn.btn-success.btn-teal-dk.create-order-btn.ng-scope");
    By ArtOfficeWidgetModule=By.cssSelector("div.wrapper-md.row.m-t-xs.animated.fadeIn>div.productBlock.ng-scope.ng-hide:nth-child(14)+div+div  a.btn.btn-success.btn-teal-dk.create-order-btn.ng-scope");
    By MyArtDocumentCreationSigning1Transaction=By.cssSelector("div.wrapper-md.row.m-t-xs.animated.fadeIn>div.productBlock.ng-scope.ng-hide:nth-child(14)+div+div+div  a.btn.btn-success.btn-teal-dk.create-order-btn.ng-scope");
    By MyArtOfficeConnectorEDOVchasno=By.cssSelector("div.wrapper-md.row.m-t-xs.animated.fadeIn>div.productBlock.ng-scope.ng-hide:nth-child(14)+div+div+div+div  a.btn.btn-success.btn-teal-dk.create-order-btn.ng-scope");
    By ArtCryptoPlusBasic=By.cssSelector("div.wrapper-md.row.m-t-xs.animated.fadeIn>div.productBlock.ng-scope:nth-child(15) a.btn.btn-success.btn-teal-dk.create-order-btn.ng-scope");
    By ArtCryptoPlusBatchSign=By.cssSelector("div.wrapper-md.row.m-t-xs.animated.fadeIn>div.productBlock.ng-scope:nth-child(16) a.btn.btn-success.btn-teal-dk.create-order-btn.ng-scope");

    /**
     * ліцензії для замовлення (ЮО)
     */
    By YoArtZvitProFopIndividualBasic=By.cssSelector("div.productBlock.ng-scope:nth-child(10)>div:nth-child(2)>div.product__items.ng-scope:nth-child(1) a.btn.btn-success.btn-teal-dk.create-order-btn.ng-scope");
    By YoArtZvitProExciseTaxReportingLegalEntities=By.cssSelector("div.productBlock.ng-scope:nth-child(10)>div:nth-child(2)>div.product__items.ng-scope:nth-child(2) a.btn.btn-success.btn-teal-dk.create-order-btn.ng-scope");
    By YoArtZvitProVATAccountingLegalEntities=By.cssSelector("div.productBlock.ng-scope:nth-child(10)>div:nth-child(2)>div.product__items.ng-scope:nth-child(3) a.btn.btn-success.btn-teal-dk.create-order-btn.ng-scope");
    By YoArtZvitProBankReporting=By.cssSelector("div.productBlock.ng-scope:nth-child(10)>div:nth-child(2)>div.product__items.ng-scope:nth-child(4) a.btn.btn-success.btn-teal-dk.create-order-btn.ng-scope");
    By YoArtZvitProNBUReportingModule=By.cssSelector("div.productBlock.ng-scope:nth-child(10)>div:nth-child(2)>div.product__items.ng-scope:nth-child(5) a.btn.btn-success.btn-teal-dk.create-order-btn.ng-scope");
    By YoArtZvitProRROModule=By.cssSelector("div.productBlock.ng-scope:nth-child(11)>div:nth-child(2)>div.product__items.ng-scope:nth-child(1) a.btn.btn-success.btn-teal-dk.create-order-btn.ng-scope");
    By YoArtZvitProTerminalLegalEntities=By.cssSelector("div.productBlock.ng-scope:nth-child(12)>div:nth-child(2)>div.product__items.ng-scope:nth-child(1) a.btn.btn-success.btn-teal-dk.create-order-btn.ng-scope");


//    $$("div.productBlock.ng-scope:nth-child(11)>div:nth-child(2)>div.product__items.ng-scope:nth-child(6) a.btn.btn-success.btn-teal-dk.create-order-btn.ng-scope")


}
