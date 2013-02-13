This is basic stuff on how to set up basic git on your computer using original "git"
---------

How git works:
---------

1. Before working it is recommended to update your LOCAL repository with the one on github (SERVER). Linux: "git pull"
2. Git tracks any changes of files that you made to the code (Difference to last LOCAL version)
3. Then you commit your changes to the LOCAL repository (folder you are working in). Linux: 'git commit -m "Your comment here"'
4. Now you can try to upload the changes and sync LOCAL and SERVER repositories. In linux, you would use "git push" and that automatically appends changes to the SERVER repository. HOWEVER if a part of your LOCAL repository is behind of the SERVER, you will get and error. Then what we need to do, is get and merge SERVER's data into our local rep. In linux, you would use "git pull" for that.

If you are using windows git with UI, I [Martyn] have not tried it out yet. Alternatively, you can use "Git Bash" which would be the same as working in linux (with command line).

If running first time
---------

    $ git config --global user.name "your_username"
    $ git config --global user.email "your_email"

Gets files and initializes git repository in your local mashine. May ask for password and username of github.

    $ git clone https://github.com/magniffico/OOTanks.git

Strongly recommended to set the master branch to:

    $ git branch --set-upstream master origin/testing

If running any other time:
---------
    
Gets the newest version of repository testing branch

    $ git pull

Pushes the online repository branch testing from local rep

    $ git push

