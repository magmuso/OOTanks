This is basic stuff on how to set up basic git on your computer using original "git"
---------

If running first time
---------

    $ git config --global user.name "your_username"
    $ git config --global user.email "your_email"

Gets files and initializes git repository in your local mashine. May ask for password and username of github.

    $ git clone https://github.com/magniffico/JavaTanks.git

If running any other time:
---------
    
Gets the newest version of repository testing branch

    $ git fetch origin testing
