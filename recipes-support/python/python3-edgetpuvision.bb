SUMMARY = "Edge TPU Python API to run inference on image data coming from the camera."
HOMEPAGE = "https://coral.googlesource.com/edgetpu"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://edgetpuvision/utils.py;endline=13;md5=35852385043d2b5bb4f52507e41aea44"

SRC_URI = "git://coral.googlesource.com/edgetpuvision;protocol=https;branch=release-chef"
SRCREV = "437ef5b065892eca461aee3db117abefc33d28aa"

S = "${WORKDIR}/git"

PV = "release-chef"

RDEPENDS_${PN} = "\
    bash \
    libedgetpu \
    python3-numpy \
    python3-pillow \
    python3-protobuf \
    python3-pygobject \
"

inherit setuptools3

BBCLASSEXTEND = "native nativesdk"
