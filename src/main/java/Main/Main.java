package Main;

import Controllere.Controller;
import Model.Model;
import View.View;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        new Controller(view,model);

    }
}
