SUMMARY = "Edge TPU Python API to run inference on image data coming from the camera."
HOMEPAGE = "https://coral.googlesource.com/edgetpu"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://edgetpuvision/utils.py;endline=13;md5=35852385043d2b5bb4f52507e41aea44"

SRC_URI = "git://coral.googlesource.com/edgetpuvision;protocol=https;branch=release-day"
SRCREV = "24a6267fb322c02d0138bc5a32cf7fb2ddf47b5b"

S = "${WORKDIR}/git"

PV = "release-day"

RDEPENDS_${PN} = "\
    bash \
    libedgetpu \
    python3-numpy \
    python3-pillow \
    python3-protobuf \
    python3-pygobject \
    python3-setuptools \
"

inherit setuptools3

BBCLASSEXTEND = "native nativesdk"
