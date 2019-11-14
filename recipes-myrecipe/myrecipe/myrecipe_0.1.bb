SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Recipe created by bitbake-layers, modified by Sami Karkinen"
LICENSE = "CLOSED"

SRC_URI = "file://just_some_text.txt "

S = "${WORKDIR}/"

FILES_${PN} += "/omaa_tavaraa/just_some_text.txt"

do_install() {
    mkdir -p ${D}/omaa_tavaraa
    cp ${S}/just_some_text.txt ${D}/omaa_tavaraa/just_some_text.txt
}
