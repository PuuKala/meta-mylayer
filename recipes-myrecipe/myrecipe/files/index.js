// Initializing variables
var id = document.getElementById('id_selection').innerHTML;
var mediastream = null;
var peer = null;

// Defining media options
const constraints = { audio: true, video: false };

// Get video
navigator.mediaDevices.getUserMedia(constraints)
    .then(function (stream) {
/*
        var video = document.getElementById('localVideo');
        video.srcObject = stream;
        video.onloadedmetadata = function (e) {
            video.play();
        };
*/
        mediastream = stream;
    })
    .catch(function (err) {
        console.log(err.name + ":", err.message);
    });


// Connect signaling server and listen for incoming calls
function start() {
    peer = new Peer(id, { host: location.hostname, port: 9000, config: {'iceServers': [{ 'urls': 'stun:'+location.hostname+':3478' }]}, secure: true, debug:3 });
};

// Call to Answerer
function call() {
    peer.call('Answerer', mediastream);
};
