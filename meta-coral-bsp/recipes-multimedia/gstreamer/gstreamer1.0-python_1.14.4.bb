SUMMARY = "Python bindings for GStreamer 1.0"
HOMEPAGE = "http://cgit.freedesktop.org/gstreamer/gst-python/"
SECTION = "multimedia"

LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=c34deae4e395ca07e725ab0076a5f740"

SRC_URI = "\
    http://gstreamer.freedesktop.org/src/${PNREAL}/${PNREAL}-${PV}.tar.xz \
    file://0001-gstpythonplugin-hard-code-libpython-path-and-name.patch \
"
SRC_URI[md5sum] = "d4c0e3915f547feef49208ee08981e5a"
SRC_URI[sha256sum] = "d0fdb24f93b6d889f309d2f526b8ea9577e0084ff0a62b4623ef1aed52e85a1b"

DEPENDS = "gstreamer1.0 python3-pygobject"
RDEPENDS:${PN} += "gstreamer1.0 python3-pygobject"

PNREAL = "gst-python"

S = "${WORKDIR}/${PNREAL}-${PV}"

# gobject-introspection is mandatory and cannot be configured
REQUIRED_DISTRO_FEATURES = "gobject-introspection-data"
UNKNOWN_CONFIGURE_WHITELIST:append = " --enable-introspection --disable-introspection"

inherit autotools pkgconfig distutils3-base upstream-version-is-even gobject-introspection distro_features_check

EXTRA_OECONF += "--with-libpython-dir=${libdir}"

do_install:append() {
    # Note that this particular find line is taken from the Debian packaging for
    # gst-python1.0.
    find "${D}" \
        -name '*.pyc' -o \
        -name '*.pyo' -o \
        -name '*.la' -o \
        -name 'libgstpythonplugin*' \
        -delete
}

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_coral-dev = "1"
