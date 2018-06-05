package ColorClickerClient.Logic;

public interface IColorClickerClientSignInSignUpLogic {
    public void SignIn(String email, String password);

    public void SignUp(String email, String password, String name);
}
