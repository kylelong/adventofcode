public class day2{
    public static void main(String [] args){
        int [] arr = {1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,1,10,19,1,19,5,23,1,6,23,27,1,27,5,
            31,2,31,10,35,2,35,6,39,1,39,5,43,2,43,9,47,1,47,6,51,1,13,51,55,2,9,55,59,1,59,
            13,63,1,6,63,67,2,67,10,71,1,9,71,75,2,75,6,79,1,79,5,83,1,83,5,87,2,9,87,91,2,9,
            91,95,1,95,10,99,1,9,99,103,2,103,6,107,2,9,107,111,1,111,5,115,2,6,115,119,1,5,
            119,123,1,123,2,127,1,127,9,0,99,2,0,14,0};

            int [] og = {1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,1,10,19,1,19,5,23,1,6,23,27,1,27,5,
                31,2,31,10,35,2,35,6,39,1,39,5,43,2,43,9,47,1,47,6,51,1,13,51,55,2,9,55,59,1,59,
                13,63,1,6,63,67,2,67,10,71,1,9,71,75,2,75,6,79,1,79,5,83,1,83,5,87,2,9,87,91,2,9,
                91,95,1,95,10,99,1,9,99,103,2,103,6,107,2,9,107,111,1,111,5,115,2,6,115,119,1,5,
                119,123,1,123,2,127,1,127,9,0,99,2,0,14,0};

            System.out.println(part1(arr));
           part2(arr, og);
        
    }
    public static int part1(int [] arr){
        int op = 0;
        int first, second, third= 0;
        arr[1] = 12;
        arr[2] = 2;

            for(int i = 0; i < arr.length; i+=4){
                op = arr[i];
                first = i + 1;
                second = i + 2;
                third = i + 3;
                if(op == 1){
                    arr[arr[third]] = arr[arr[first]] + arr[arr[second]];
                } else if(op == 2){
                    arr[arr[third]] = arr[arr[first]] * arr[arr[second]];
                }
                else{
                    return arr[0];
                }
    
            }
            return arr[0];
        


    }

    public static void part2(int [] arr, int [] og){
        int verb = 0 , noun = 0;
        while(part1(arr) != 19690720 ){
            arr = og;
            while(verb < 100){
                noun = 0;
                while(noun < 100){
                    arr[1] = noun;
                    arr[2] = verb;
                    if(part1(arr) == 19690720){
                        System.out.println(100 * noun + verb);
                        break;
                    }
                    noun++;
                }
                verb++;
            }

        }
    }
}