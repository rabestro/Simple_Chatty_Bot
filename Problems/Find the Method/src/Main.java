import java.lang.reflect.Method;
import java.util.Arrays;

class MethodFinder {

    public static String findMethod(String methodName, String[] classNames) throws ClassNotFoundException {
        for (var name : classNames) {
            var isFound = Arrays
                    .stream(Class.forName(name).getMethods())
                    .map(Method::getName)
                    .anyMatch(methodName::equals);
            if (isFound) {
                return name;
            }
        }
        return null;
    }
}