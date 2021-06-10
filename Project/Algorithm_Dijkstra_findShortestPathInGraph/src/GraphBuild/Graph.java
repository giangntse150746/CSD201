package GraphBuild;


public class Graph {
    private void setupArray() {
                         // a     b     c     d     e     f     g     h     i     j //
        Integer graph[][] = {
                    /*a*/ {    0, null, null, null,    1, null, null,   10, null, null}, 
                    /*b*/ { null,    0,    2, null, null, null, null, null, null, null},
                    /*c*/ { null, null,    0, null, null, null, null, null, null, null},
                    /*d*/ {    4, null, null,    0, null, null, null,    1, null, null},
                    /*e*/ { null, null, null, null,    0,    3, null, null, null, null},
                    /*f*/ { null,    1,    3, null, null,    0,    7, null,    1, null},
                    /*g*/ { null, null, null, null, null, null,    0, null, null, null},
                    /*h*/ { null, null, null, null, null, null, null,    0, null, null},
                    /*i*/ { null, null, null, null, null, null, null, null,    0,    2},
                    /*j*/ { null, null, null, null, null, null,    1, null, null,    0},
                        };
    }
    
    private void setupArrayBW(Integer graph[][]) {
                         // 0  1  2  3  4  5  6  7  8  9
        Integer Graph[][] = {
                    /*0*/ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                    /*1*/ { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0},
                    /*2*/ { 0, 0, 0, 0, 0, 1, 0, 1, 1, 0},
                    /*3*/ { 0, 1, 1, 1, 0, 0, 1, 1, 1, 0},
                    /*4*/ { 0, 1, 0, 1, 0, 1, 1, 0, 0, 0},
                    /*5*/ { 0, 1, 0, 1, 1, 1, 0, 1, 0, 0},
                    /*6*/ { 0, 1, 0, 0, 0, 0, 1, 1, 1, 0},
                    /*7*/ { 0, 1, 0, 1, 0, 0, 1, 1, 1, 0},
                    /*8*/ { 0, 1, 0, 1, 0, 0, 1, 1, 1, 0},
                    /*9*/ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        };
        graph = Graph;
    }
     
}
