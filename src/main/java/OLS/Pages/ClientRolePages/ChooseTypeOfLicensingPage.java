package OLS.Pages.ClientRolePages;

import OLS.Pages.BasePage.BasePageClass;
import OLS.Common.ElementHelper;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static OLS.Common.Config.LICENSE_ID_USING_IN_REQEST;
import static OLS.Common.Config.ORG_SUBJECT_TYPE_FOR_REQEST;
import static OLS.Common.ElementHelper.checkDiactivateCheckbox;
import static OLS.Common.DriverHelper.logger;

public class ChooseTypeOfLicensingPage
{
    WebDriver driver;

    public ChooseTypeOfLicensingPage(WebDriver driver)
    {
        this.driver=driver;
    }

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
    By checkBoxNeedToChangeVpr=By.cssSelector("input[data-ng-model='dealerInfoModel.IsChange']");

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
                    choseTypeOfReqestAtGetToStep1(AzReqestList, AzReqestListReporting,YoArtZvitProFopIndividualBasic);
                    break;

                case 2:
                    choseTypeOfReqestAtGetToStep1(AzReqestList, AzReqestListReporting,YoArtZvitProExciseTaxReportingLegalEntities);
                    break;

                case 3:
                    choseTypeOfReqestAtGetToStep1(AzReqestList, AzReqestListReporting,YoArtZvitProVATAccountingLegalEntities);
                    break;

                case 4:
                    choseTypeOfReqestAtGetToStep1(AzReqestList, AzReqestListReporting,YoArtZvitProBankReporting);
                    break;

                case 5:
                    choseTypeOfReqestAtGetToStep1(AzReqestList, AzReqestListReporting,YoArtZvitProNBUReportingModule);
                    break;

                case 6:
                    choseTypeOfReqestAtGetToStep1(AzReqestList, AzReqestListSoftwareRRO,YoArtZvitProRROModule);
                    break;

                case 7:
                    choseTypeOfReqestAtGetToStep1(AzReqestList, AzReqestListTerminalVersion,YoArtZvitProTerminalLegalEntities);
                    break;

                case 8:
                    choseTypeOfReqestAtGetToStep1(AzReqestList, AzReqestListAdditionalServices,ArtZvitProPrimaryDocModule);
                    break;
                case 9:
                    choseTypeOfReqestAtGetToStep1(AzReqestList, AzReqestListAdditionalServices,ArtZvitProPrimaryDocTransaction1);
                    break;

                case 10:
                    choseTypeOfReqestAtGetToStep1(ArtOfficeReqestList,ArtOfficeModule1C);
                    break;

                case 11:
                    choseTypeOfReqestAtGetToStep1(ArtOfficeReqestList,ArtOfficeWidgetModule);
                    break;

                case 12:
                    choseTypeOfReqestAtGetToStep1(ArtOfficeReqestList,MyArtDocumentCreationSigning1Transaction);
                    break;

                case 13:
                    choseTypeOfReqestAtGetToStep1(ArtOfficeReqestList,MyArtOfficeConnectorEDOVchasno);
                    break;

                case 14:
                    choseTypeOfReqestAtGetToStep1(ArtCryptoReqestList,ArtCryptoPlusBasic);
                    break;

                case 15:
                    choseTypeOfReqestAtGetToStep1(ArtCryptoReqestList,ArtCryptoPlusBatchSign);
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
                    choseTypeOfReqestAtGetToStep1(AzReqestList, AzReqestListReporting,FopArtZvitProFopIndividualBasic);
                    break;
                case 17:
                    choseTypeOfReqestAtGetToStep1(AzReqestList, AzReqestListReporting,FopArtZvitLiteFopWithoutEmployees);
                    break;
                case 18:
                    choseTypeOfReqestAtGetToStep1(AzReqestList, AzReqestListReporting,FopRightToSwitchToIndividualBasicLicense);
                    break;
                case 19:
                    choseTypeOfReqestAtGetToStep1(AzReqestList, AzReqestListReporting,FopArtZvitProModuleRro);
                    break;
                case 20:
                    choseTypeOfReqestAtGetToStep1(AzReqestList, AzReqestListReporting,FopArtZvitProTerminal);
                    break;
                case 8:
                    choseTypeOfReqestAtGetToStep1(AzReqestList, AzReqestListAdditionalServices,ArtZvitProPrimaryDocModule);
                    break;
                case 9:
                    choseTypeOfReqestAtGetToStep1(AzReqestList, AzReqestListAdditionalServices,ArtZvitProPrimaryDocTransaction1);
                    break;

                case 10:
                    choseTypeOfReqestAtGetToStep1(ArtOfficeReqestList,ArtOfficeModule1C);
                    break;

                case 11:
                    choseTypeOfReqestAtGetToStep1(ArtOfficeReqestList,ArtOfficeWidgetModule);
                    break;

                case 12:
                    choseTypeOfReqestAtGetToStep1(ArtOfficeReqestList,MyArtDocumentCreationSigning1Transaction);
                    break;

                case 13:
                    choseTypeOfReqestAtGetToStep1(ArtOfficeReqestList,MyArtOfficeConnectorEDOVchasno);
                    break;

                case 14:
                    choseTypeOfReqestAtGetToStep1(ArtCryptoReqestList,ArtCryptoPlusBasic);
                    break;

                case 15:
                    choseTypeOfReqestAtGetToStep1(ArtCryptoReqestList,ArtCryptoPlusBatchSign);
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
            ElementHelper.WaitUntilElementWillBePresentOnPage2(driver, changeVPRModal);
            Assertions.assertTrue(checkDiactivateCheckbox(driver, checkBoxNeedToChangeVpr));
            WebElement element= ElementHelper.WaitUntilElementWillBeClickableOnPage(driver, continueAtСhangeVPRModal);
            element.click();
        }
        catch(TimeoutException e)
        {
            logger.info("Кліент не привязаний до жодного ВПР");
        }
    }



    private void choseTypeOfReqestAtGetToStep1(By ReqestList, By ReqestListGroupeOfLicense, By TypeOfLicense )
    {
        ElementHelper.WaitUntilElementWillBePresentOnPage10(driver, ReqestList).click();
        ElementHelper.WaitUntilElementWillBePresentOnPage10(driver, ReqestListGroupeOfLicense).click();
        ElementHelper.WaitUntilElementWillBePresentOnPage10(driver, TypeOfLicense).click();
        checkInfoAboutChangeVPR();
        String checkText= ElementHelper.WaitUntilElementWillBePresentOnPage10(driver, textOnStep1).getText();
        Assertions.assertEquals("Крок 1: Внесіть відомості про послуги", checkText);
        logger.info("----Start of 1-t Step----");
    }

    private void choseTypeOfReqestAtGetToStep1(By ReqestList, By TypeOfLicense )
    {
        ElementHelper.WaitUntilElementWillBePresentOnPage10(driver, ReqestList).click();
        ElementHelper.WaitUntilElementWillBeClickable10(driver, TypeOfLicense).click();
        checkInfoAboutChangeVPR();
        String checkText= ElementHelper.WaitUntilElementWillBePresentOnPage10(driver, textOnStep1).getText();
        Assertions.assertEquals("Крок 1: Внесіть відомості про послуги", checkText);
    }



}
