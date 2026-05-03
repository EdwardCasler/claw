# claw
A FTC library for setting up simple movement.


# SETUP
Download the file and drag it into your teamcode folder.

# USAGE
create a new bot object. MecanumBot bot = new MecanumBot();  
call SetMotorNames with the names of the motors in your driver station. bot.SetMotorNames("fr", "fl", "br", "bl");  
call Init with you hardware map. bot.Init(hardwareMap);  
reverse motor directions if needed.  

Then in your loop call Drive(gamePad1);

# This does not support other drive trains types yet.
