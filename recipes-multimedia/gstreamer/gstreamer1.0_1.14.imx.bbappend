FILESEXTRAPATHS_prepend_coral-dev := "${THISDIR}/${PN}-${PV}:"

# Patches from https://coral.googlesource.com/imx-gstreamer
#
# Generated using:
#
#    git format-patch rel_imx_4.14.98_2.0.0_ga..1.14.4+imx-3
SRC_URI_append_coral-dev = " \
    file://0001-Unmark-GstDebugColorFlags-as-flags.patch \
    file://0002-buffer-Add-GstParentBufferMeta-to-copied-buffer-shar.patch \
    file://0003-Revert-Unmark-GstDebugColorFlags-as-flags.patch \
    file://0004-buffer-Free-memory-before-meta.patch \
"
