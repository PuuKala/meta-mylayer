SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Recipe created by bitbake-layers, modified by Sami Karkinen"
LICENSE = "CLOSED"

SRC_URI = "file://just_some_text.txt "

S = "${WORKDIR}/"

FILES_${PN} += "\
/node_server/readme.txt \
/node_server/server.js \
/node_server/website/index.html \
/node_server/website/index.js \
"

do_install() {
    mkdir -p ${D}/node_server
    mkdir -p ${D}/node_server/website
    cp ${S}/readme.txt ${D}/node_server/readme.txt
    cp ${S}/server.js ${D}/node_server/server.js
    cp ${S}/index.js ${D}/node_server/website/index.js
}

RDEPENDS_${PN} = "nodejs"
