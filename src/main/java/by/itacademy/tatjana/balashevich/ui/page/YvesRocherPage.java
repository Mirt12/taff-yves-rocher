package by.itacademy.tatjana.balashevich.ui.page;

public class YvesRocherPage {
    String url = "https://www.y-r.by";
    String homePageCloseLanguageModalLocator = "//button[@aria-label='Close']";
    String homePageLoginLinkLocator = "//a[@href='/auth/login']";
    String authorizationLinkLocator = "//h2[contains(text(),'�����������')]";
    String loginFormInputEmailLocator = "//input[@id='user-email']";
    String loginFormInputPwdLocator = "//input[@id='user-password']";
    String submitLoginFormButtonLocator = "//button[contains(text(),'�����������')]";
    String emailErrorLocator = "//val-errors[@controlname='email']/div[1]";
    String passwordErrorLocator = "//val-errors[@controlname='password']/div[1]";
    String expectedloginErrorText = "��� ���� �������� ������������";
    String expectedEmailErrorText = "Email ������ ���� ��������";
}
