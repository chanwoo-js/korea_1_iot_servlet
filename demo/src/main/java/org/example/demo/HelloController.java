package org.example.demo;

// 컨트롤러
// model 의 데이터를 가져와 view 에 전달하는 역할
// 모델과 뷰를 중재하여 데이터 처리와 화면 출력을 분리하는 역할을 한다.
public class HelloController {
    private HelloModel model;
    private HelloView view;
    public HelloController() {
        model = new HelloModel();
        view = new HelloView();
    }

    public void handleRequest() {
        String message = model.getMessage(); // model 에서 데이터를 가져와
        view.displayMessage(message); // view 에 전달하여 출력
    }
}
