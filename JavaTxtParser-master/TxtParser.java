//class dotData has two integers (x,y) and their getters


class txtParser {
    /**
     * @param f is the file.
     * @param x List<dotData> which contains x.
     */
    private File f;
    private List<dotData> x;
    private long time;

    public txtParser() {

        this.f = null;
    }

    /**
     * Read : Reads the Integers from the file and storing it to a list.
     * @param name
     */
    public void Read(String name) throws IOException {
        time = System.currentTimeMillis();
        try {
            f = new File(name);
        } catch (Exception e) {
            System.out.println("Error :File not Found");
            System.out.println("Location:"+name);
            System.exit(-1);
        }
        BufferedReader br = new BufferedReader(new FileReader(f));
        String line= br.readLine();
        int a  = Integer.parseInt(line);
        this.x = Stream.generate(dotData::new).limit(a).collect(Collectors.toList());
        int i = 0;
        int xx,yy;
        while (i<a) {
            line = new String(br.readLine());
            boolean xy = true;
            xx = 0;
            yy = 0;
            int digit = 0;
            for (int it=0 ; it<line.length();it++){
                char omg = line.charAt(it);
                if (omg>47&&omg<=58){
                    int ax = omg-48;
                    if (xy){
                        xx = (int) (xx*(10));
                        digit = digit+1;
                        xx +=ax;

                    }
                    else{
                        yy = (int) (yy*(10));
                        digit = digit+1;
                        yy +=ax;

                    }
                }
                else{
                    xy = !xy;
                }
            }
            x.get(i).setDatax(xx);
            x.get(i).setDatay(yy);
            i++;
        }
        time = System.currentTimeMillis() - time;
        //System.out.println((System.currentTimeMillis()-time));
    }
