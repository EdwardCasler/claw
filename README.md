# claw
A FTC library for setting up simple movement.


# SETUP
create a new bot object. MecanumBot bot = new MecanumBot();  
call SetMotorNames with the names of the motors in your driver station. bot.SetMotorNames("fr", "fl", "br", "bl");  
call Init with you hardware map. bot.Init(hardwareMap);  
reverse motor directions if needed.  

Then in your loop call Drive(gamePad1);
