package back.cmm.module.cmm.base.util;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

@Component
public class ExecUtil {

    public Map<String, Object> execCmd(String... cmd) {
        try {
            List<String> commands = new ArrayList<>();
            Map<Integer, Object> result = new HashMap<>();
            if (System.getProperty("os.name").startsWith("Windows")) {
                commands.add("cmd.exe");
                commands.add("/c");
            } else {
                String joinedCmd = String.join(" ", cmd);
                commands.add("/bin/sh");
                commands.add("-c");
                commands.add("sudo " + joinedCmd);  // 명령어 전체를 따옴표로 감싸서 추가
            }
            commands.addAll(Arrays.asList(cmd));

            ProcessBuilder builder = new ProcessBuilder(commands);
            builder.redirectErrorStream(true);
            Process process = builder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;

            int rowNum = 0;
            while ((line = reader.readLine()) != null) {

                String lines = Arrays.toString(line.split(System.lineSeparator()));
//                System.out.println("lines : " + lines);
                String[] lineSplit = line.split(System.lineSeparator());
                ArrayList<String> strings = new ArrayList<>();

                for (String s : lineSplit) {
                    Object[] array = Arrays.stream(s.split("  ")).filter((ss) -> !ss.isEmpty()).toArray();
                    for (Object o : array) {
//                        System.out.println("o : " + o.toString().trim());
                        strings.add(o.toString().trim());
                    }
                }

                result.put(rowNum++, strings);
                output.append(line).append(System.lineSeparator());
            }
//            System.out.println("result : " + result.toString());

            Map<String, Object> realResult = new HashMap<>();
            realResult.put("string", output.toString());
            realResult.put("object", result);

            return realResult;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
