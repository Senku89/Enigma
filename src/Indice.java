package src;

public class Indice {

        private String txtReponse;
        private String txt0;
    private String txt1;
    private String txt2;
    private String txt3;

    public Indice(String Reponse, String text0, String text1, String text2, String text3) {
            this.txtReponse = Reponse ;
            this.txt0 = text0;
            this.txt1 = text1;
            this.txt2 = text2;
            this.txt3 = text3;
        }

        public String getTxtReponse() {
            return txtReponse;
        }

        public String getTxt0() {
            return txt0;
        }
    public String getTxt1() { return txt1;    }
    public String getTxt2() { return txt2;    }
    public String getTxt3() {
        return txt3;
    }



        @Override
        public String toString() {
            return "DataInstance{" +
                    "reponse='" + txtReponse + '\'' +
                    ", indice0='" + txt0 + '\'' +
                    ", indice1='" + txt1 + '\'' +
                    ", indice2='" + txt2 + '\'' +
                    ", indice3='" + txt3 + '\'' +
                    '}';
        }
    }






