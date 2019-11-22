SUMMARY = "Python OpenCV to website"
DESCRIPTION = "Pip install opencv-python-headless, flask_opencv_streamer and copy python scripts to the machine. Recipe created by Sami Karkinen"
LICENSE = "CLOSED"

inherit pypi setuptools

PYPI_PACKAGE = "flask_opencv_streamer"

# TODO: Make the files and mention them in SRC_URI
SRC_URI = "\
file://readme.txt \
"

S = "${WORKDIR}/git"

# TODO: Make the files and mention them in FILES_(PN)
FILES_${PN} += "\
/pythoncv/ \
"

# TODO: Copy the files to (D)/pythoncv
do_install() {
    mkdir -p ${D}/pythoncv
    cp ${WORKDIR}/ ${D}/pythoncv
}
