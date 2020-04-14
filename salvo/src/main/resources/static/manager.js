$(function() {

    // display text in the output area
   function showOutput(text) {

   $("#output").text(text);

   }

   // load and display JSON sent by server for /players
   function loadData() {

   $.get("/players")
   .done(function(data) {

   showOutput(JSON.stringify(data, null, 2));

   })

   .fail(function( jqXHR, textStatus ) {
   showOutput( "Failed: " + textStatus );

   });

   }

   // handler for when user clicks add person

   function addPlayer() {

   var name = $("#name").val();
   var id = $("#id").val();
   var game = $("#game").val();


   if (name && id && game) {

   postPlayer(name, id, game);

   }

   }

   function updatePlayer() {

   var name = $("#name").val();
   var id = $("#id").val();
   var game = $("#game").val();


   if (name && id && game) {

   putPlayer(name, id, game);

   }

   }
   function deletePlayer() {

   var name = $("#name").val();


   if (name) {

   removePlayer(name);

   }

   }

   // code to post a new player using AJAX
   // on success, reload and display the updated data from the server

   function postPlayer(userName, id, game) {

   $.post({

   headers: {

   'Content-Type': 'application/json'

   },

   dataType: "text",
   url: "/players",
   data: JSON.stringify({ "id": id,"name": userName, "game":game })

   })

   .done(function( ) {

   showOutput( "Saved – reloading");
   loadData();

   })

   .fail(function( jqXHR, textStatus ) {

   showOutput( "Failed: " + textStatus );

   });

   }
   function putPlayer(userName, id, game) {
   console.log(userName)
    $.ajax({
        url: `/players/${userName}`,
        type: 'PUT',
        data: JSON.stringify({ "id": id,"name": userName, "game":game }),
        contentType: 'application/json',
        success: function(response) {
          console.log('putted')}
        })


   .done(function( ) {

   showOutput( "Saved – reloading");
   loadData();

   })

   .fail(function( jqXHR, textStatus ) {

   showOutput( "Failed: " + textStatus );

   });

   }
   function removePlayer(userName) {


    $.ajax({
        url: `/players/${userName}`,
        type: 'DELETE',

        contentType: 'application/json',
        success: function(response) {
          console.log('deleted')}
        })

   .done(function() {

   loadData()

   })

   .fail(function( jqXHR, textStatus ) {
   showOutput( "Failed: " + textStatus );

   });


   }





   $("#add_player").on("click", addPlayer);
   $("#delete_player").on("click", deletePlayer);
   $("#update_player").on("click", updatePlayer);
   loadData();
   });

