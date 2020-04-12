SUMMARY = "Edge TPU demo script"
HOMEPAGE = "https://coral.googlesource.com/edgetpu"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://debian/copyright;md5=1b8c88ab53bb4adbc408415870a3e89b"

SRC_URI = "git://coral.googlesource.com/edgetpudemo;protocol=https;branch=release-day"
SRCREV = "d0670d1cc40bf523e78eddccef9950a93f0662d4"

S = "${WORKDIR}/git"

RDEPENDS_${PN} = "\
    bash \
    python3-edgetpuvision \
    python3-setuptools \
"

do_install() {
    install -d ${D}/${bindir}
    install -m 755 ${S}/edgetpu_demo ${D}/${bindir}

    install -d ${D}/${datadir}
    cp -R --no-dereference --preserve=mode,links -v ${S}/edgetpudemo ${D}/${datadir}
}

FILES_${PN} += "${datadir}/edgetpudemo"
