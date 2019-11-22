from flask_opencv_streamer.streamer import Streamer
from cv2 import VideoCapture, waitKey

port = 5000
require_login = False
streamer = Streamer(port, require_login)

cap = VideoCapture(0)

print('Starting to read camera and host flask in port:', port)

while True:
    success, frame = cap.read()
    streamer.update_frame(frame)
    if not streamer.is_streaming:
        streamer.start_streaming()
    
    waitKey(66)
