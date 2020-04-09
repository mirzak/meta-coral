DESCRIPTION = "PyOpenGL is the most common cross platform Python binding to OpenGL and related APIs"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://license.txt;md5=603fc14206e108ce9cd85ef7fc7d3025"

SRC_URI[md5sum] = "fcb5bdd0d48da86d9f6124716831de93"
SRC_URI[sha256sum] = "4107ba0d0390da5766a08c242cf0cf3404c377ed293c5f6d701e457c57ba3424"

PYPI_PACKAGE = "PyOpenGL"

inherit pypi setuptools3
