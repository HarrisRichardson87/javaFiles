const aplha = ["a","b","c","d","e","f","g","h","i","j"];

const createBoard = () => {
  console.log(data.ships[0].locations[0])
  $("#header").append(`<th id=0 class="cell table-active" scope="col"></th>
  `)
  for (let index = 0; index < aplha.length; index++) {
    $("#header").append(`<th id=${index} class="cell table-active" scope="col">${index + 1}</th>
    `)
    $("#tbody").append(`<tr id=tr${index}></tr>`);
    $("#tbody").find(`#tr${index}`).append(`<th id = "${aplha[index]}"class="cell table-active" scope="row">${aplha[index]}</th>`)
    
    for (let x = 0; x < 10; x++) {
      $("#tbody").find(`#tr${index}`).append(`<td class="cell bg-info"></td>`)
    }
    
  }
}

const deploy = (data) =>{
  data.ships.forEach((a,i)=>{
      let spot = data.ships[0].locations[i].split("");
      aplha.forEach((a,i) =>{
        console.log(a,i)
        if(a == spot[0].toLowerCase()){
          x = i + 1
          return
        }
      })
      let y = parseInt(spot[1]);
      let battleship = document.getElementById("game_board").rows[x].cells.item(y);
      battleship.innerHTML = "ship"
      battleship.style.color = "red";
      })
    
}

$("#start").click(function () {
  createBoard();
  $('#start').hide();
  $('#title').append(`<h2> Welcome ${data.gameplayers[0].player.name}</h2>`)
});

$("#ship_deploy").click(function () {
deploy(data); 
$('#ship_deploy').hide();
});
loadData();
let data = loadData()

function loadData() {
  // let data = '';
  // fetch("api/game_view/1", {
  //     method: "GET",
  // }).then(function (res) {
  //     console.log(res)
  //     return res.json();
  // })
  let data = {
    id: 1,
    created: "2020-04-16T15:04:04.160+0000",
    gameplayers: [
    {
    id: 2,
    player: {
    id: 2,
    name: "Player One"
    }
    },
    {
    id: 1,
    player: {
    id: 1,
    name: "Player Two"
    }
    }
    ],
    ships: [
    {
    type: "Cruzer",
    locations: [
    "H3",
    "H2"
    ]
    }
    ]
    };
    console.log(data)
    return data

 }

function loadData() {
  fetch("api/game_view/1", {
      method: "GET",
  }).then(function (res) {
      console.log(res)
      return res.json();
  })
}