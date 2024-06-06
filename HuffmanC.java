import java.util.*;


public class HuffmanC{

    HashMap<Character, String> encoder;
    HashMap<String, Character> decoder;

    private class Node implements Comparable<Node>{
        Character data;
        int cost;
        Node left;
        Node right;

        public Node(Character data, int cost){
            this.data = data;
            this.cost = cost;
            this.left = null;
            this.right = null;
                     
        }
        @Override 
        public int compareTo(Node other){
            return this.cost - other.cost;
        }
    }
    public HuffmanC(String feeder) throws Exception{
        HashMap<Character, Integer> fmap = new HashMap<>();

        for (int i = 0; i<feeder.length(); i++) {
          char cc = feeder.charAt(i);
          if(fmap.containsKey(cc)){
            int ov = fmap.get(cc);
            ov += 1;
            fmap.put(cc, ov);
          }  else{
            fmap.put(cc,1);
          }
        }
        Heap<Node> minHeap = new Heap<>();
        Set<Map.Entry<Character, Integer>> entrySet = fmap.entrySet();

        for(Map.Entry<Character, Integer> entry : entrySet){
            Node node = new Node(entry.getKey(), entry.getValue());
            minHeap.insert(node);

        }
        while(minHeap.size() != 1){
            Node first = minHeap.remove();
            Node second = minHeap.remove();

            Node newNode = new Node('\0', first.cost + second.cost);
            newNode.left = first;
            newNode.right = second;     
            
            minHeap.insert(newNode);
            }
            Node ft = minHeap.remove();

            this.encoder = new HashMap<>();
            this.decoder = new HashMap<>();

            this.initEncoderDecoder(ft, "");
        }
            private void initEncoderDecoder(Node node, String osf) {
                if(node == null){
                    return;
                }
                    if(node.left == null && node.right == null){
                        this.encoder.put(node.data, osf);
                        this.decoder.put(osf, node.data);
                    }
                    initEncoderDecoder(node.left, osf+"0");
                    initEncoderDecoder(node.right, osf+"1");

                
            }
            public String encode(String source){
                String ans = "";
                for(int i = 0; i<source.lenght(); i++){
                  ans = ans + encoder.get(source.charAt(i));
                }
                return ans;
            }
        public String decode(String source codeString){
            String key = "";
            for(int i = 0; i<codeString.length();i++){
                key = key+ codeString.charAt(i);
                if(decode.containsKey(key)){
                    ans = ans + decoder.get(key);
                    key = "";
                }
            }
            return ans;
        }
    }}