class Main{
    public static void main(String[] args) throws Exception{
        String str = "abbccdda";
        HuffmanC hf = new HuffmanC(str);
        String cs = hf.encode(str);
        System.out.println(cs);
        String dc = hf.decode(cs);
        System.out.println(ds);

        
    }
}