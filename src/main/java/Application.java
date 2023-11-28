import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        /* 애플리케이션 시작 */
        System.out.println("===== 자바 미니숍에 오신 것을 환영합니다 =====");

        /* 사용자로부터 입력받는 값 */
        int button = 0;
        String command = "";

        while (true) {

            System.out.println("1. 로그인");
            System.out.println("2. 회원가입");
            System.out.println("3. 종료");

            /* int 가 아닌 잘못된 값을 입력할 경우 예외 */
            try {
                System.out.print("버튼을 눌러주세요 : ");
                button = scanner.nextInt();
                scanner.nextLine(); // 버퍼 비우기
            } catch (InputMismatchException e) {
                warningInput();
                scanner.nextLine(); // 버퍼 비우기
                continue;
            }

            /* 메뉴얼에 없는 값 입력 할 경우 */
            if (button < 1 || button > 3) {
                invalidChoice();
                continue;
            }

            /* 종료 */
            if (button == 3) {
                System.out.println("===== 미니숍 애플리케이션을 종료합니다 =====");
                return;
            }

            /* 로그인 */
            if (button == 1) {

                String email;
                String password;

                System.out.println("===== 로그인을 시작합니다 =====");
                System.out.print("Email :  ");
                email = scanner.nextLine();

                System.out.print("Password : ");
                password = scanner.nextLine();

                return;
            }

            /* 회원가입 */
            if (button == 2) {

            }
        }
    }

    private static void warningInput() {
        System.out.println("==================================================");
        System.out.println("(Warning) 잘못된 명령어입니다. 다시 입력해 주세요.");
        System.out.println("==================================================");
    }

    private static void invalidChoice() {
        System.out.println("==================================================");
        System.out.println("(Failing) 잘못된 선택입니다. 다시 선택해 주세요.");
        System.out.println("==================================================");
    }

}
