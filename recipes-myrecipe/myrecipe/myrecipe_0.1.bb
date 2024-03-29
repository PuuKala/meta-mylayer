SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Recipe created by bitbake-layers, modified by Sami Karkinen"
LICENSE = "CLOSED"

SRC_URI = "\
file://readme.txt \
file://server.js \
file://node-key.pem \
file://node-cert.pem \
file://index.html \
file://index.js \
file://peerjs.js \
file://hax.html \
file://404.html \
"

S = "${WORKDIR}/git"

FILES_${PN} += "\
/node_server/readme.txt \
/node_server/server.js \
/node_server/node-key.pem \
/node_server/node-cert.pem \
/node_server/website/index.html \
/node_server/website/index.js \
/node_server/website/peerjs.js \
/node_server/website/hax.html \
/node_server/website/404.html \
"

do_install() {
    mkdir -p ${D}/node_server
    mkdir -p ${D}/node_server/website
    cp ${WORKDIR}/readme.txt ${D}/node_server
    cp ${WORKDIR}/server.js ${D}/node_server
    cp ${WORKDIR}/node-key.pem ${D}/node_server
    cp ${WORKDIR}/node-cert.pem ${D}/node_server
    cp ${WORKDIR}/index.html ${D}/node_server/website
    cp ${WORKDIR}/index.js ${D}/node_server/website
    cp ${WORKDIR}/peerjs.js ${D}/node_server/website
    cp ${WORKDIR}/hax.html ${D}/node_server/website
    cp ${WORKDIR}/404.html ${D}/node_server/website
}

RDEPENDS_${PN} = "nodejs"
