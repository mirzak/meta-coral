SUMMARY = "Edge TPU Python API"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=19d1f00e43228427ebb9a48f2e175959"

require recipes-support/common/edgetpu-common.inc

S = "${WORKDIR}/git"

PV = "release-chef"

RDEPENDS_${PN} = "libedgetpu python3 python3-numpy python3-pillow"
RDEPENDS_${PN}-examples = "bash ${PN}"

inherit setuptools3

PACKAGES += "${PN}-examples"

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

do_install_append() {
    install -d ${D}/${datadir}/edgetpu/examples/
    install -d ${D}/${datadir}/edgetpu/examples/models
    install -d ${D}/${datadir}/edgetpu/examples/images

    cp -R --no-dereference --preserve=mode,links -v ${S}/test_data/*.jpg \
        ${D}/${datadir}/edgetpu/examples/images

    cp -R --no-dereference --preserve=mode,links -v ${S}/test_data/*.tflite \
        ${D}/${datadir}/edgetpu/examples/models

    cp -R --no-dereference --preserve=mode,links -v ${S}/test_data/*.txt \
        ${D}/${datadir}/edgetpu/examples/models

    cp -R --no-dereference --preserve=mode,links -v ${S}/edgetpu/demo/*  ${D}/${datadir}/edgetpu/examples/
}

FILES_${PN}-examples = "${datadir}/edgetpu/examples/"

BBCLASSEXTEND = "native nativesdk"

INSANE_SKIP_${PN} += "already-stripped"
