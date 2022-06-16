function show_and_hide() {
    var x = document.getElementById("passwordInput");
    if (x.type === "password") {
        console.log("switch to text")
        x.type = "text";
    } else {
        x.type = "password";
    }
}

/*
function startConn() {

    var start = document.getElementsByName("options");

    $('input:radio[name="options"]').click(function () {

        var checkValue = $('input:radio[name="options"]:checked').val();
        if (checkValue == 1) {

            while (true) {
                console.log("Inside func1");
                var getStatus = $.ajax({
                    url: "/getConnection",
                    type: "GET",
                    datatype: "text",
                    error: function () {
                        console.log("沒有新訂單！");
                    },
                    success: function (result) {

                        if (result == "TRUE") {
                            if (confirm("是否接收訂單？")) {
                                location.reload;

                            } else {
                                console.log("沒有新訂單！")
                            }
                        }
                    }


                })
            }

        } else if (checkValue == 2) {

            console.log("cancel");
            getStatus.abort();

        }

    });

}
*/


function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

var ConnSwitch = true;
async function startConn() {

    for (let i = 0; i <= 100; i++) {
        console.log("Inside func1");
        await sleep(10000);
        if (ConnSwitch) {
            var getStatus = $.ajax({
                url: "/getConnection",
                type: "GET",
                datatype: "text",
                error: function () {
                    console.log("ERROR!!!!");
                },
                success: function (result) {

                    if (result == "TRUE") {
                        document.getElementById('alert').play();
                        if (confirm("是否接收訂單？")) {
                            window.location.reload();
                            console.log("ACCEPT!!")
                            startConn();

                        } else {
                            console.log("沒有新訂單！")
                        }
                    }
                }


            })
        } else if(ConnSwitch == false){
            break;
        }
    }

    alert("連線逾時，請重新連線");
    getStatus.abort();

}

function stopConn() {
    console.log("STOP_CONNECT");
    ConnSwitch = false;

}
