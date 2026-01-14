import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new  StringTokenizer(br.readLine());
        int ar[] = new int[4];
        // 임의로 만든 DNA 문자열 길이 S
        int S = Integer.parseInt(st.nextToken());
        // 비밀번호로 사용할 부분문자열의 길이 P
        int P =  Integer.parseInt(st.nextToken());

        // 민호가 만든 임의로 만든 DNA 문자열이 주어짐
        String str = br.readLine();

        // 부분문자열에 포함되어야 할 A,C,G,T의 최소 개수가 공백을 구분으로 주어짐
        st =  new  StringTokenizer(br.readLine());
        for(int i=0 ; i<4; i++)
            ar[i] = Integer.parseInt(st.nextToken());

        Map<Character, Integer> map = new HashMap<>();
        // 맨 처음 스캔해서 값 저장해두기
        for(int i=0; i<P; i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }

        int result = 0;
        for(int i = P; i<S; i++) {
            // map에서 개수를 가져옴
            int aCount = map.getOrDefault('A',0);
            int cCount = map.getOrDefault('C',0);
            int gCount = map.getOrDefault('G',0);
            int tCount = map.getOrDefault('T',0);
            if(aCount>=ar[0] && cCount>=ar[1] && gCount>=ar[2] && tCount>=ar[3])
                result++;
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
            map.put(str.charAt(i-P), map.get(str.charAt(i-P))-1);
        }
        int aCount = map.getOrDefault('A',0);
        int cCount = map.getOrDefault('C',0);
        int gCount = map.getOrDefault('G',0);
        int tCount = map.getOrDefault('T',0);
        if(aCount>=ar[0] && cCount>=ar[1] && gCount>=ar[2] && tCount>=ar[3])
            result++;
        System.out.println(result);
    }
}
