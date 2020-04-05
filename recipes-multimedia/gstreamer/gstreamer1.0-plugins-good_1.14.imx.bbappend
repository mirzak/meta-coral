FILESEXTRAPATHS_prepend_coral-dev := "${THISDIR}/${PN}-${PV}:"

# Patches from https://coral.googlesource.com/imx-gst-plugins-good
#
# Generated using:
#
#    git format-patch rel_imx_4.14.98_2.0.0_ga..1.14.4+imx-5
#
# Patches that update include paths are excluded
SRC_URI_append_coral-dev = " \
    file://0001-Increase-number-of-v4l2-capture-buffers.patch \
    file://0002-Never-enable-v4l2-buffer-copies.patch \
    file://0003-Disable-all-libv4l2-emulated-formats-with-V4L2_DISAB.patch \
"
