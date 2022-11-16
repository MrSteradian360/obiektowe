package agh.ics.oop;

public class OptionsParser {
    public MoveDirection[] parse(String[] args){
        MoveDirection[] dir = new MoveDirection[args.length];
        int j = 0;
        for(int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "f", "forward" -> dir[j] = MoveDirection.FORWARD;
                case "b", "backward" -> dir[j] = MoveDirection.BACKWARD;
                case "l", "left" -> dir[j] = MoveDirection.LEFT;
                case "r", "right" -> dir[j] = MoveDirection.RIGHT;
                default -> j--;
            }
            j++;
        }
        MoveDirection[] dir1 = new MoveDirection[j];
        for (int i = 0; i < j; i++){
            dir1[i] = dir[i];
        }
//            int i = 0;

//            int j = 0;
//            while(i < args.length){
//                if(dir[i] == )
//                dir[j] = switch(args[j]){
//                    case "f", "forward" -> MoveDirection.FORWARD;
//                    case "b", "backward" -> MoveDirection.BACKWARD;
//                    case "l", "left" -> MoveDirection.LEFT;
//                    case "r", "right" -> MoveDirection.RIGHT;
//                };
//        }
//        for (MoveDirection i : dir){
//
//        }
        return dir1  ;
    }
}
