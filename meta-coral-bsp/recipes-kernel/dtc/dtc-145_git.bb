SUMMARY = "Device Tree Compiler"
HOMEPAGE = "https://devicetree.org/"
DESCRIPTION = "The Device Tree Compiler is a tool used to manipulate the Open-Firmware-like device tree used by PowerPC kernels."
SECTION = "bootloader"
LICENSE = "GPLv2 | BSD-2-Clause"
DEPENDS = "flex-native bison-native"

LIC_FILES_CHKSUM = " \
    file://GPL;md5=94d55d512a9ba36caa9b7df079bae19f \
    file://libfdt/libfdt.h;beginline=3;endline=52;md5=fb360963151f8ec2d6c06b055bcbb68c \
"

SRC_URI = "git://git.kernel.org/pub/scm/utils/dtc/dtc.git;branch=master \
           file://make_install.patch \
           file://0001-Fix-compiler-warnings-seen-with-musl.patch \
           "
SRCREV = "22a65c5331c22979d416738eb756b9541672e00d"

UPSTREAM_CHECK_GITTAGREGEX = "v(?P<pver>\d+(\.\d+)+)"

EXTRA_OEMAKE='NO_PYTHON=1 PREFIX="${prefix}" LIBDIR="${libdir}" DESTDIR="${D}"'

inherit pkgconfig

S = "${WORKDIR}/git"

# only install the dtc binary renamed to dtc-145
do_install () {
    install -d ${D}/${bindir}
    install -m 755 dtc ${D}/${bindir}/dtc-145
}

PACKAGES =+ "${PN}-misc"
FILES:${PN}-misc = "${bindir}/convert-dtsv0 ${bindir}/ftdump ${bindir}/dtdiff"

RDEPENDS:${PN}-misc += "bash diffutils"

BBCLASSEXTEND = "native nativesdk"
