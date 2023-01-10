DESCRIPTION = "Acceleration code for PyOpenGL"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://license.txt;md5=615289fea9c74eaa77dc514e27560274"

SRC_URI[md5sum] = "489338a4818fa63ea54ff3de1b48995c"
SRC_URI[sha256sum] = "927f4670b893d46e2f6273ae938bf0a1db27ffae3336eba94813ccef6260c410"

PYPI_PACKAGE = "PyOpenGL-accelerate"

inherit pypi setuptools3

SRC_URI += "file://0001-fix-compability-with-cython-029.13.patch;striplevel=2"

DEPENDS += "python3-numpy-native"
RDEPENDS:${PN} += "python3-pyopengl"
