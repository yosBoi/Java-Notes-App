# Java-Notes-App
Notes app made using spring boot and angular

Frontend (angular project) has start script in package.json, run 'npm run start' after installing npm packages.
Frontend runs on localhost:4200 and backend runs on localhost:3000

backend has the following REST endpoints

/register (POST) - accepts a json input in user model format and saves the new user to db after encoding the password using bCrypt
/generate-token (POST) - authenticates the user (from email and password) and returns a jwt token
/notes/get (GET) - detects the user from the jwt token and returns their 10 latest notes from the db
/notes/add (POST) - adds a new note into the db
/notes/delete (POST) - deletes a note from the db

all notes endpoints are secured and cannot be accessed without a valid jwt token

additionally, a scheduled task runs every one hour to delete each users notes if they exceed 10 notes.

the spring boot application connects to sql db on 3306 port where a database named "notes" should exist

Frontend has the following pages

/home - shows options to login or register
/login
/register
/notes - see notes
/add - add note

/notes and /add pages are secured using guard so only logged in users can access them
the jwt token is stored in localstorage upon successful login and is attached to every subsequent request using interceptor