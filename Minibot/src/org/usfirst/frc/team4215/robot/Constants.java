package org.usfirst.frc.team4215.robot;

/**
 * 
 * @author James Yu
 *
 */

public class Constants {

	    
	    public final class Motor {
	        
	        public final class Num {
	            
	            public final static int FrontLeft = 3, BackLeft = 1,
	                    BackRight = 2, FrontRight = 0, Arm1 = 4,
	                    Intake = 5, Arm2 = 6;
	        }

	        public final class Run {
	            
	            public final static double Forward = 1d, Backward = -1d,
	                    Stop = 0d;

	        }
	    }

	    public final class JoyStick {
	        
	        public final class Num {
	            

	            public final static int PlayStation = 1, GameCube = 2;
	        }

	        public final class Axis {
	            
	            public final static int PlayStationCtrlLeft_UD = 1,
	                    PlayStationCtrlRight_UD = 5;

	            public final static int GameCubeCtrl_UD = 1,
	                    GameCubeCtrl_LR = 0;
	        }

	        public final class Button {
	            
	            public final static int GameCube_Y = 1, GameCube_X = 2,
	                    GameCube_A = 3, GameCube_B = 4;
	        }
	    }
	}


