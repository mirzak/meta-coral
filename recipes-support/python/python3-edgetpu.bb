SUMMARY = "Edge TPU Python API"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=19d1f00e43228427ebb9a48f2e175959"

require recipes-support/common/edgetpu-common.inc

S = "${WORKDIR}/git"

PV = "release-chef"

RDEPENDS_${PN} = "libedgetpu python3 python3-numpy python3-pillow"

inherit setuptools3

do_install_append_x86_64() {
    rm ${D}${PYTHON_SITEPACKAGES_DIR}/edgetpu/swig/*arm-linux-gnueabihf*
    rm ${D}${PYTHON_SITEPACKAGES_DIR}/edgetpu/swig/*aarch64*
    mv ${D}${PYTHON_SITEPACKAGES_DIR}/edgetpu/swig/_edgetpu_cpp_wrapper.cpython-*-x86_64-linux-gnu.so \
       ${D}${PYTHON_SITEPACKAGES_DIR}/edgetpu/swig/_edgetpu_cpp_wrapper.so
}

do_install_append_arm() {
    rm ${D}${PYTHON_SITEPACKAGES_DIR}/edgetpu/swig/*x86_64*
    rm ${D}${PYTHON_SITEPACKAGES_DIR}/edgetpu/swig/*aarch64*
    mv ${D}${PYTHON_SITEPACKAGES_DIR}/edgetpu/swig/_edgetpu_cpp_wrapper.cpython-*-arm-linux-gnueabihf.so \
       ${D}${PYTHON_SITEPACKAGES_DIR}/edgetpu/swig/_edgetpu_cpp_wrapper.so
}

do_install_append_aarch64() {
    rm ${D}${PYTHON_SITEPACKAGES_DIR}/edgetpu/swig/*x86_64*
    rm ${D}${PYTHON_SITEPACKAGES_DIR}/edgetpu/swig/*arm-linux-gnueabihf*
    mv ${D}${PYTHON_SITEPACKAGES_DIR}/edgetpu/swig/_edgetpu_cpp_wrapper.cpython-*-aarch64-linux-gnu.so \
       ${D}${PYTHON_SITEPACKAGES_DIR}/edgetpu/swig/_edgetpu_cpp_wrapper.so
}

BBCLASSEXTEND = "native nativesdk"
