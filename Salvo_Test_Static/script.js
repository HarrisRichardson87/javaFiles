const data = [
    {
    id: 1,
    created: "2020-04-08T21:10:55.474+0000",
    gameplayers: [
    {
    id: 1,
    players: {
    id: 2,
    name: "player2"
    }
    },
    {
    id: 2,
    players: {
    id: 1,
    name: "player1"
    }
    }
    ]
    },
    {
    id: 2,
    created: "2020-04-08T21:10:55.474+0000",
    gameplayers: [ ]
    },
    {
    id: 3,
    created: "2020-04-08T21:10:55.474+0000",
    gameplayers: [ ]
    }
    ]
$(function() {

    // display text in the output area
   function showOutput(data) {
  
    for(let i = 0; i < data.length; i++){
        console.log("test")
        $("#output").append(`<h3 id="next">Game number ${data[i].id} at ${data[i].created} has</h3>`);
        data[i].gameplayers.map(element => {
            console.log(element.players,"here")
            $("#next").append(`<p id="nextPlayers">Gameplayer id ${element.id} with ready ${element.players.name}</p>`);
            console.log(element.players.name)
        });

    }

   }

   // load and display JSON sent by server for /players
   function loadData() {

//    $.get("http://localhost:8080/api/list")
//    .done(function(data) {

   showOutput((data));

//    })

//    .fail(function( jqXHR, textStatus ) {
//    showOutput( "Failed: " + textStatus );

//    });

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



   loadData();
   });

