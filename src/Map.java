import java.util.ArrayList;

public class Map {
    String[][] tileId;
    ArrayList<Integer>[] tileNo;
    ArrayList<Path> paths = new ArrayList<>();
    int offset = 10;


    // home ID = 9
    // first path IDs  = 0 , 1 , 2
    // second path IDs = 3 , 4 , 5
    // third path IDs  = 6 , 7 , 8
    // intersection ID = #
    // otherwise --> *
    Map(){
        tileId = new String[900][1600];
        tileNo = new ArrayList[9];


        Path path0 = new Path();
        Path path1 = new Path();
        Path path2 = new Path();
        Path path3 = new Path();
        Path path4 = new Path();
        Path path5 = new Path();
        Path path6 = new Path();
        Path path7 = new Path();
        Path path8 = new Path();



        /*
        // tileIds are initialized wit *
        for (int i = 0; i < 900; i++){
            for (int j = 0; j < 1600; j++){
                tileId[i][j] = "*";
            }
        }

        // home ID = 9
        for (int i = 420; i < 480; i++){
            for (int j = 1500; j < 1600; j++){
                tileId[i][j] = "9";
            }
        }
        */
        ////////////////////////////////// first path /////////////////////////////////////////////////
        // path IDs : 0 , 1 , 2
        int[] counter = new int[3];
        counter[0] = 0;
        counter[1] = 0;
        counter[2] = 0;

        for (int j = 0; j < 500; j++){

            path0.buildPath(300,j);
            path1.buildPath(300 + offset,j);
            path2.buildPath(300 + 2*offset,j);

            /*tileId[300][j] = "0";
            //tileId[300+offset][j] = "1";
            //tileId[300+2*offset][j] = "2";
            //tileNo[0].add(counter[0]++);
            //tileNo[1].add(counter[1]++);
            //tileNo[2].add(counter[2]++); */

        }
        for (int i = 0; i <100; i++ ){

            path0.buildPath( 300-i-1  , 500 + i );
            path1.buildPath( 300-i-1 + offset , 500 + i );
            path2.buildPath( 300-i-1 + 2*offset , 500 + i );

            /*for (int j = 500; j < 600; j++){



                tileId[i][j] = "0";
                tileId[i+offset][j] = "1";
                tileId[i+2*offset][j] = "2";
                tileNo[0].add(counter[0]++);
                tileNo[1].add(counter[1]++);
                tileNo[2].add(counter[2]++);
            }*/
        }
        for (int j = 600; j < 1200; j++){

            path0.buildPath( 200  , j );
            path1.buildPath( 200 + offset , j );
            path2.buildPath( 200 + 2*offset , j );

            /*
            tileId[200][j] = "0";
            tileId[200+offset][j] = "1";
            tileId[200+2*offset][j] = "2";
            tileNo[0].add(counter[0]++);
            tileNo[1].add(counter[1]++);
            tileNo[2].add(counter[2]++); */
        }


        for( int i=0; i<230; i++ ){

            path0.buildPath( 200+ i+1  , 1200 + i );
            path1.buildPath( 200+ i+1 + offset , 1200 + i );
            path2.buildPath( 200+ i+1 + 2*offset , 1200 + i );

        }

        /*for (int i = 201; i <= 430; i++){
            for (int j = 1200; j < 1430; j++){
                tileId[i][j] = "0";
                tileId[i+offset][j] = "1";
                tileId[i+2*offset][j] = "2";
                tileNo[0].add(counter[0]++);
                tileNo[1].add(counter[1]++);
                tileNo[2].add(counter[2]++);
            }
        }*/

        for (int j = 1430; j < 1500; j++){

            path0.buildPath( 430  , j );
            path1.buildPath( 430 + offset , j );
            path2.buildPath( 430 + 2*offset , j );

            /*
            tileId[430][j] = "0";
            tileId[430+offset][j] = "1";
            tileId[430+2*offset][j] = "2";
            tileNo[0].add(counter[0]++);
            tileNo[1].add(counter[1]++);
            tileNo[2].add(counter[2]++); */
        }

        /*counter[0] = 0;
        counter[1] = 0;
        counter[2] = 0; */
        ///////////////////////////// second path //////////////////////////////
        // path IDs : 3 , 4 , 5
        for (int j = 0; j < 600; j++){

            path3.buildPath( 600  , j );
            path4.buildPath( 600 + offset , j );
            path5.buildPath( 600 + 2*offset , j );

            /* tileId[600][j] = "3";
            tileId[600+offset][j] = "4";
            tileId[600+2*offset][j] = "5";
            tileNo[3].add(counter[0]++);
            tileNo[4].add(counter[1]++);
            tileNo[5].add(counter[2]++); */
        }


        for( int i=0; i<50; i++ ){

            path3.buildPath( 600 -i-1  , 600 +i+1 );
            path4.buildPath( 600 -i-1 + offset , 600 +i+1 );
            path5.buildPath( 600 -i-1 + 2*offset , 600 +i+1 );
        }
        /*
        for (int i = 599; i >= 550; i--){
            for (int j = 601; j <= 650; j++){
                tileId[i][j] = "3";
                tileId[i+offset][j] = "4";
                tileId[i+2*offset][j] = "5";
                tileNo[3].add(counter[0]++);
                tileNo[4].add(counter[1]++);
                tileNo[5].add(counter[2]++);
            }
        } */


        for (int j = 651; j < 850; j++){

            path3.buildPath( 550  , j );
            path4.buildPath( 550 + offset , j );
            path5.buildPath( 550 + 2*offset , j );

            /* tileId[550][j] = "3";
            tileId[550+offset][j] = "4";
            tileId[550+2*offset][j] = "5";
            tileNo[3].add(counter[0]++);
            tileNo[4].add(counter[1]++);
            tileNo[5].add(counter[2]++); */
        }


        for( int i=0; i<200; i++ ){

            path3.buildPath( 550 +i+1  , 850 +i );
            path4.buildPath( 550 +i+1 + offset , 850 +i );
            path5.buildPath( 550 +i+1 + 2*offset , 850 +i );
        }

        /*for (int i = 551; i <= 750; i++){
            for (int j = 850; j < 1050; j++){
                tileId[i][j] = "3";
                tileId[i+offset][j] = "4";
                tileId[i+2*offset][j] = "5";
                tileNo[3].add(counter[0]++);
                tileNo[4].add(counter[1]++);
                tileNo[5].add(counter[2]++);
            }
        }*/

        for (int j = 1050; j <= 1550; j++){

            path3.buildPath( 750  , j );
            path4.buildPath( 750 + offset , j );
            path5.buildPath( 750 + 2*offset , j );

            /* tileId[750][j] = "3";
            tileId[750+offset][j] = "4";
            tileId[750+2*offset][j] = "5";
            tileNo[3].add(counter[0]++);
            tileNo[4].add(counter[1]++);
            tileNo[5].add(counter[2]++); */
        }

        for (int cnt = 0; cnt < offset; cnt++){

            path4.buildPath( 750 + offset, 1550 + cnt+1 );
            /* tileId[750+offset][1550+cnt] = "4";
            tileId[750+offset-cnt][1550+offset] = "4";
            tileNo[4].add(counter[1]++); */
        }

        for (int cnt = offset-1; cnt >= 0; cnt--){

            path4.buildPath( 750 + offset -cnt-1, 1550 + offset );
        }

        for (int cnt = 0; cnt < 2*offset; cnt++){

            path5.buildPath( 750 + 2*offset, 1550+cnt+1 );
            /* tileId[750+2*offset][1550+cnt] = "5";
            tileId[750+2*offset-cnt][1550+2*offset] = "5";
            tileNo[5].add(counter[2]++); */
        }

        for (int cnt = 2*offset-1; cnt >= 0; cnt--){

            path5.buildPath( 750 + 2*offset - cnt-1, 1550 + 2*offset );
            /* tileId[750+2*offset][1550+cnt] = "5";
            tileId[750+2*offset-cnt][1550+2*offset] = "5";
            tileNo[5].add(counter[2]++); */
        }
        for (int i = 749; i >= 480; i--){

            path3.buildPath( i  , 1550 );
            path4.buildPath( i  , 1550 + offset );
            path5.buildPath( i  , 1550+ 2*offset );

            /* tileId[i][1550] = "3";
            tileId[i][1550+offset] = "4";
            tileId[i][1550+2*offset] = "5";
            tileNo[3].add(counter[0]++);
            tileNo[4].add(counter[1]++);
            tileNo[5].add(counter[2]++); */
        }


        /*counter[0] = 0;
        counter[1] = 0;
        counter[2] = 0;*/
        /////////////////////////////// third path ////////////////////////////////////////
        // path IDs : 6 , 7 , 8
        for (int i = 899; i > 699; i--){

            path6.buildPath( i  , 590 );
            path7.buildPath( i  , 590 + offset );
            path8.buildPath( i  , 590+ 2*offset );
            /*tileId[i][590] = "6";
            tileId[i][590+offset] = "7";
            tileId[i][590+2*offset] = "8";
            tileNo[6].add(counter[0]++);
            tileNo[7].add(counter[1]++);
            tileNo[8].add(counter[2]++);*/
        }

        for (int i = 0; i < 100; i++){
            path6.buildPath( 700-i-1  , 590 + i );
            path7.buildPath( 700-i-1  , 590 + offset + i );
            path8.buildPath( 700-i-1  , 590+ 2*offset + i);
        }
        /*for (int i = 699; i >= 600; i--){
            for (int j = 590; j < 690; j++){
                tileId[i][j] = "6";
                tileId[i][j+offset] = "7";
                tileId[i][j+2*offset] = "8";
                tileNo[6].add(counter[0]++);
                tileNo[7].add(counter[1]++);
                tileNo[8].add(counter[2]++);
            }
        }*/

        for (int i = 599; i >= 480; i--){

            path6.buildPath( i  , 690 );
            path7.buildPath( i  , 690 + offset );
            path8.buildPath( i  , 690+ 2*offset );
            /*tileId[i][690] = "6";
            tileId[i][690+offset] = "7";
            tileId[i][690+2*offset] = "8";
            tileNo[6].add(counter[0]++);
            tileNo[7].add(counter[1]++);
            tileNo[8].add(counter[2]++);*/
        }

        for (int cnt = 0; cnt < offset; cnt++){

            path7.buildPath(480 - cnt - 1, 690 + offset);
            /*tileId[480-cnt][690+offset] = "7";
            tileId[480-offset][690+offset+cnt] = "7";
            tileNo[7].add(counter[1]++);*/
        }

        for (int cnt = 0; cnt < offset; cnt++){

            path7.buildPath(480 - offset, 690 + offset + cnt + 1);
            /*tileId[480-cnt][690+offset] = "7";
            tileId[480-offset][690+offset+cnt] = "7";
            tileNo[7].add(counter[1]++);*/
        }

        for (int cnt = 0; cnt < 2*offset; cnt++){

            path6.buildPath(480 - cnt - 1, 690);
            /*tileId[480-cnt][690] = "8";
            tileId[480-2*offset][690+cnt] = "8";
            tileNo[8].add(counter[2]++);*/
        }

        for (int cnt = 0; cnt < 2*offset; cnt++){

            path6.buildPath(480 - 2 * offset, 690 + cnt + 1);
            /*tileId[480-cnt][690] = "8";
            tileId[480-2*offset][690+cnt] = "8";
            tileNo[8].add(counter[2]++);*/
        }

        for (int j = 690+2*offset+1; j < 1500; j++){

            path6.buildPath( 480-2*offset  , j );
            path7.buildPath( 480 - offset  , j );
            path8.buildPath( 480  , j );
            /*tileId[460][j] = "6";
            tileId[460+offset][j] = "7";
            tileId[460+2*offset][j] = "8";
            tileNo[6].add(counter[0]++);
            tileNo[7].add(counter[1]++);
            tileNo[8].add(counter[2]++);*/
        }

        // intersections are marked with #
        /*tileId[550][690] = "#";
        tileId[550][700] = "#";
        tileId[550][710] = "#";

        tileId[560][690] = "#";
        tileId[560][700] = "#";
        tileId[560][710] = "#";

        tileId[570][690] = "#";
        tileId[570][700] = "#";
        tileId[570][710] = "#";*/

        paths.add(path0);
        paths.add(path1);
        paths.add(path2);
        paths.add(path3);
        paths.add(path4);
        paths.add(path5);
        paths.add(path6);
        paths.add(path7);
        paths.add(path8);
    }

    // returns the next coordinate of a given coordinate
    // if the given coordinate is the last coordinate of the path the method returns (450,1599)
    public Coordinate nextCoordinate(Coordinate currentCoordinate){
        for (Path path : paths ) {
            if(path.isInWay(currentCoordinate)){
                return path.nextCoordinate(currentCoordinate);
            }
        }
        return null;
    }

    // Just to see if a specific Coordinate is in a path
    public Boolean isInWay(Coordinate coordinate){
        for (Path path : paths){
           if (path.isInWay(coordinate)){
               return true;
           }
        }
        return false;
    }


}
