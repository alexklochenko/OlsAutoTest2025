package OLS.Pages.ClientRolePages;

import OLS.Pages.BasePage.BasePageClass;
import OLS.Pages.BasePage.WebElementHelper;
import org.apache.commons.io.TaggedIOException;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static OLS.Common.Config.LICENSE_ID_USING_IN_REQEST;
import static OLS.Common.Config.ORG_SUBJECT_TYPE_FOR_REQEST;

public class ChooseTypeOfLicensingPage
{
    WebDriver driver;

    public ChooseTypeOfLicensingPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public static String VPRName;
    /**
     * Типи замовлення
     */
    By AzReqestList=By.cssSelector("div.wrapper-sm.row.bg-light.m-l-none.m-r-none.m-t-n-sm.sm_screen>div.ng-scope:nth-of-type(1)>div.col-lg-3.col-md-3.col-sm-6.col-xs-12.left a.ng-scope");
    By ArtOfficeReqestList=By.cssSelector("div.wrapper-sm.row.bg-light.m-l-none.m-r-none.m-t-n-sm.sm_screen>div.ng-scope:nth-of-type(2)>div.col-lg-3.col-md-3.col-sm-6.col-xs-12.left a.ng-scope");
    By ArtCryptoReqestList=By.cssSelector("div.wrapper-sm.row.bg-light.m-l-none.m-r-none.m-t-n-sm.sm_screen>div.ng-scope:nth-of-type(3)>div.col-lg-3.col-md-3.col-sm-6.col-xs-12.left a.ng-scope");
    By KEPReqestList=By.cssSelector("div.wrapper-sm.row.bg-light.m-l-none.m-r-none.m-t-n-sm.sm_screen>div.ng-scope:nth-of-type(4)>div.col-lg-3.col-md-3.col-sm-6.col-xs-12.left a.ng-scope");

    /**
     * Группи ліцензій для Арт Звввіт Про
     */
    By AzReqestListReporting=By.cssSelector("div.wrapper-md.row.m-t-xs.animated.fadeIn>div.productBlock.ng-scope:nth-of-type(10)");
    By AzReqestListSoftwareRRO=By.cssSelector("div.wrapper-md.row.m-t-xs.animated.fadeIn>div.productBlock.ng-scope:nth-of-type(11)");
    By AzReqestListTerminalVersion=By.cssSelector("div.wrapper-md.row.m-t-xs.animated.fadeIn>div.productBlock.ng-scope:nth-of-type(12)");
    By AzReqestListAdditionalServices=By.cssSelector("div.wrapper-md.row.m-t-xs.animated.fadeIn>div.productBlock.ng-scope:nth-of-type(14)");

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

    /**
     * Обробка модального вікна зміни обслуговуючої компанії
     */
    By changeVPRModal=By.cssSelector("div.modal-content>div.ng-scope");
    By continueAtСhangeVPRModal=By.cssSelector("button.btn.btn-primary.ng-scope");

    By infoAboutVPR=By.cssSelector("div.alert.alert-info strong");

    /**
     * Контрольні елементи на кроці1
     */
    By textOnStep1=By.cssSelector("div.col-sm-12.col-xs-12>h2");

    public void stratNewReqest()
    {
        BasePageClass.checkLicensingForOrgSubjectType();

        if (ORG_SUBJECT_TYPE_FOR_REQEST==1)
        {
            switch(LICENSE_ID_USING_IN_REQEST)
            {
                case 1:
                    choseTypeOfReqestAntGetToStep1(AzReqestList, AzReqestListReporting,YoArtZvitProFopIndividualBasic);
                    break;

                case 2:
                    choseTypeOfReqestAntGetToStep1(AzReqestList, AzReqestListReporting,YoArtZvitProExciseTaxReportingLegalEntities);
                    break;

                case 3:
                    choseTypeOfReqestAntGetToStep1(AzReqestList, AzReqestListReporting,YoArtZvitProVATAccountingLegalEntities);
                    break;

                case 4:
                    choseTypeOfReqestAntGetToStep1(AzReqestList, AzReqestListReporting,YoArtZvitProBankReporting);
                    break;

                case 5:
                    choseTypeOfReqestAntGetToStep1(AzReqestList, AzReqestListReporting,YoArtZvitProNBUReportingModule);
                    break;

                case 6:
                    choseTypeOfReqestAntGetToStep1(AzReqestList, AzReqestListSoftwareRRO,YoArtZvitProRROModule);
                    break;

                case 7:
                    choseTypeOfReqestAntGetToStep1(AzReqestList, AzReqestListTerminalVersion,YoArtZvitProTerminalLegalEntities);
                    break;

                case 8:
                    choseTypeOfReqestAntGetToStep1(AzReqestList, AzReqestListAdditionalServices,ArtZvitProPrimaryDocModule);
                    break;
                case 9:
                    choseTypeOfReqestAntGetToStep1(AzReqestList, AzReqestListAdditionalServices,ArtZvitProPrimaryDocTransaction1);
                    break;

                case 10:
                    choseTypeOfReqestAntGetToStep1(ArtOfficeReqestList,ArtOfficeModule1C);
                    break;

                case 11:
                    choseTypeOfReqestAntGetToStep1(ArtOfficeReqestList,ArtOfficeWidgetModule);
                    break;

                case 12:
                    choseTypeOfReqestAntGetToStep1(ArtOfficeReqestList,MyArtDocumentCreationSigning1Transaction);
                    break;

                case 13:
                    choseTypeOfReqestAntGetToStep1(ArtOfficeReqestList,MyArtOfficeConnectorEDOVchasno);
                    break;

                case 14:
                    choseTypeOfReqestAntGetToStep1(ArtCryptoReqestList,ArtCryptoPlusBasic);
                    break;

                case 15:
                    choseTypeOfReqestAntGetToStep1(ArtCryptoReqestList,ArtCryptoPlusBatchSign);
                    break;

                default :
                    throw new UnsupportedOperationException("The specified license type in the LICENSE_ID_USING_IN_REQEST parameter is not valid");
            }
        }

        if (ORG_SUBJECT_TYPE_FOR_REQEST==2 || ORG_SUBJECT_TYPE_FOR_REQEST==3 )
        {
            switch(LICENSE_ID_USING_IN_REQEST)
            {
                case 16:
                    choseTypeOfReqestAntGetToStep1(AzReqestList, AzReqestListReporting,FopArtZvitProFopIndividualBasic);
                    break;
                case 17:
                    choseTypeOfReqestAntGetToStep1(AzReqestList, AzReqestListReporting,FopArtZvitLiteFopWithoutEmployees);
                    break;
                case 18:
                    choseTypeOfReqestAntGetToStep1(AzReqestList, AzReqestListReporting,FopRightToSwitchToIndividualBasicLicense);
                    break;
                case 19:
                    choseTypeOfReqestAntGetToStep1(AzReqestList, AzReqestListReporting,FopArtZvitProModuleRro);
                    break;
                case 20:
                    choseTypeOfReqestAntGetToStep1(AzReqestList, AzReqestListReporting,FopArtZvitProTerminal);
                    break;
                case 8:
                    choseTypeOfReqestAntGetToStep1(AzReqestList, AzReqestListAdditionalServices,ArtZvitProPrimaryDocModule);
                    break;
                case 9:
                    choseTypeOfReqestAntGetToStep1(AzReqestList, AzReqestListAdditionalServices,ArtZvitProPrimaryDocTransaction1);
                    break;

                case 10:
                    choseTypeOfReqestAntGetToStep1(ArtOfficeReqestList,ArtOfficeModule1C);
                    break;

                case 11:
                    choseTypeOfReqestAntGetToStep1(ArtOfficeReqestList,ArtOfficeWidgetModule);
                    break;

                case 12:
                    choseTypeOfReqestAntGetToStep1(ArtOfficeReqestList,MyArtDocumentCreationSigning1Transaction);
                    break;

                case 13:
                    choseTypeOfReqestAntGetToStep1(ArtOfficeReqestList,MyArtOfficeConnectorEDOVchasno);
                    break;

                case 14:
                    choseTypeOfReqestAntGetToStep1(ArtCryptoReqestList,ArtCryptoPlusBasic);
                    break;

                case 15:
                    choseTypeOfReqestAntGetToStep1(ArtCryptoReqestList,ArtCryptoPlusBatchSign);
                    break;

                default :
                    throw new UnsupportedOperationException("The specified license type in the LICENSE_ID_USING_IN_REQEST parameter is not valid");
            }
        }
    }



    public void   checkInfoAboutChangeVPR ()
    {
        try
        {
            WebElementHelper.WaitUntilElementWillBePresentOnPage10(driver, changeVPRModal);
            WebElementHelper.WaitUntilElementWillBePresentOnPage10(driver, continueAtСhangeVPRModal).click();
        }
        catch(TimeoutException e)
        {
            throw new TimeoutException("Кліент не привязаний до жодного ВПР");
        }
    }



    private void choseTypeOfReqestAntGetToStep1(By ReqestList, By ReqestListGroupeOfLicense, By TypeOfLicense )
    {
        WebElementHelper.WaitUntilElementWillBePresentOnPage10(driver, ReqestList).click();
        WebElementHelper.WaitUntilElementWillBePresentOnPage10(driver, ReqestListGroupeOfLicense).click();
        WebElementHelper.WaitUntilElementWillBePresentOnPage10(driver, TypeOfLicense).click();
        checkInfoAboutChangeVPR();
        String checkText=WebElementHelper.WaitUntilElementWillBePresentOnPage10(driver, textOnStep1).getText();
        Assertions.assertEquals("Крок 1: Внесіть відомості про послуги", checkText);
    }

    private void choseTypeOfReqestAntGetToStep1(By ReqestList, By TypeOfLicense )
    {
        WebElementHelper.WaitUntilElementWillBePresentOnPage10(driver, ReqestList).click();
        WebElementHelper.WaitUntilElementWillBePresentOnPage10(driver, TypeOfLicense).click();
        checkInfoAboutChangeVPR();
        String checkText=WebElementHelper.WaitUntilElementWillBePresentOnPage10(driver, textOnStep1).getText();
        Assertions.assertEquals("Крок 1: Внесіть відомості про послуги", checkText);
    }



}
