SUMMARY = "Edge TPU demo script"
HOMEPAGE = "https://coral.googlesource.com/edgetpu"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://debian/copyright;md5=956154a3c0c73b1ff21dad10bac4a719"

SRC_URI = "git://coral.googlesource.com/edgetpudemo;protocol=https;branch=release-chef"
SRCREV = "cc8109bc1ae6009228a3a6e12397d7c95d7e6813"

S = "${WORKDIR}/git"

RDEPENDS_${PN} = "gstreamer1.0-python python3-edgetpu python3-edgetpuvision"

# This is probably a bug in upstream, gstreamer1.0-plugins-base
# package has the following content:
#
#└── usr
#    └── lib
#        └── girepository-1.0
#            ├── GstAllocators-1.0.typelib
#            ├── GstApp-1.0.typelib
#            ├── GstAudio-1.0.typelib
#            ├── GstGL-1.0.typelib
#            ├── GstPbutils-1.0.typelib
#            ├── GstRtp-1.0.typelib
#            ├── GstRtsp-1.0.typelib
#            ├── GstSdp-1.0.typelib
#            ├── GstTag-1.0.typelib
#            └── GstVideo-1.0.typelib
#
# This demo application requires the "GstPbutils-1.0.typelib" and the only
# way to make sure it is installed is by adding the following:
RDEPENDS_${PN} += "gstreamer1.0-plugins-base"

do_install() {
    install -d ${D}/${bindir}
    install -m 755 ${S}/edgetpu_demo ${D}/${bindir}

    install -d ${D}/${datadir}
    cp -r ${S}/edgetpudemo ${D}/${datadir}
}

FILES_${PN} += "${datadir}/edgetpudemo"
